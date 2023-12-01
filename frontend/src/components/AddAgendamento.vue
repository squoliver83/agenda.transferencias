<template>
    <form @submit="onSubmit" class="add-form">
        <div class="form-control">
            <label>Conta origem</label>
            <input v-model="contaOrigem" type="text" name="contaOrigem" placeholder="Conta de origem" />
        </div>
        <div class="form-control">
            <label>Conta destino</label>
            <input v-model="contaDestino" type="text" name="contaDestino" placeholder="Conta de destino" />
        </div>
        <div class="form-control">
            <label>Valor</label>
            <input 
                v-model="valor" 
                type="number" 
                step=0.01 
                min=0 
                name="valor" 
                placeholder="0" 
            />
        </div>
        <div class="form-control">
            <label>Data de transferência</label>
            <input
                v-model="dataTransferencia" 
                type="date"
                :min=minDate
                name="dataTransferencia"
            />            
        </div>
        <input type="submit" value="Agendar" class="btn btn-block">
    </form>
</template>

<script>
export default {
    //onfocus="(this.type='date')"
    name: 'AddAgendamento',
    data() {
        return {
            contaOrigem: '',
            contaDestino: '',
            valor: '',
            dataTransferencia: ''
        }
    },
    methods: {
        onSubmit(e) {
            e.preventDefault()

            if(!this.contaOrigem || !this.contaDestino || !this.valor) {
                alert('Por favor, preencha todos os campos');
                return;
            }

            const newAgendamento = {
                contaOrigem: this.contaOrigem,
                contaDestino: this.contaDestino,
                valor: this.valor,
                dataTransferencia: new Date(this.dataTransferencia),
            }

            this.$emit('add-agendamento', newAgendamento)
            
            this.contaOrigem = ''
            this.contaDestino = ''
            this.valor = ''
            this.dataTransferencia = ''
        },
        minDate() {
            return new Date().toLocaleDateString()
        }
    }
}
</script>

<style scoped>
    .add-form {
        margin-bottom: 40px;
    }

    .form-control {
        margin: 20px 0;
    }

    .form-control label {
        display: block;
    }

    .form-control input {
        width: 100%;
        height: 40px;
        margin: 5px;
        padding: 3px 7px;
        font-size: 17px;
    }
</style>