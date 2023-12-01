<template>
	<AddAgendamento 
		v-show="showAddAgendamento" 
		@add-agendamento="addAgendamento" 
	/>	
	<Agendamentos
		:agendamentos="agendamentos" 
	/>
</template>

<script>
import Agendamentos from '../components/Agendamentos'
import AddAgendamento from '../components/AddAgendamento'

export default {
    name: 'Home',
    props: {
        showAddAgendamento: Boolean
    },
    components: {
        Agendamentos,
        AddAgendamento,
    },
    data() {
        return {
            agendamentos: [],
        }
	},
    methods: {
		async addAgendamento(agendamento) {
			try {
				const res = await fetch('http://localhost:8081/api/agendamentos', {
					method: 'POST',
					headers: {
						'Content-type': 'application/json',
					},
					body: JSON.stringify(agendamento),
				})
				if (!res.ok) {
					if(res.status === 400) {
						return res.json().then((data) => {
							const msg = data.message;
							alert(msg);
						})
					} else if(res.status === 422) {
						return res.json().then(data => {
							let errorMsgs = []							
							data.errors.forEach(e => {
								let err = {
									fieldName: e.fieldName,
									msg: e.message
								};
								errorMsgs.push(err);
							});
							let msg = ''
							errorMsgs.forEach(err => {
								msg = err.msg + '\n'
							})
							alert(msg);
						})						
					} else {
						throw new Error(`${res.status} ${res.statusText}`)
					}
				}
				const data = await res.json()
				data.taxa = data.taxa.toFixed(2)
				data.valor = data.valor.toFixed(2)
				this.agendamentos = [...this.agendamentos, data]
			} catch(error) {
				console.error(error);
			}
		},
		
		async fetchAgendamentos() {
			const res = await fetch('http://localhost:8081/api/agendamentos')
			const data = await res.json();
			data.map((agendamento) => {
				agendamento.taxa = agendamento.taxa.toFixed(2);
				agendamento.valor = agendamento.valor.toFixed(2);
			})
			return data;
		}	
	},
	async created() {
		this.agendamentos = await this.fetchAgendamentos();
	}
}

</script>