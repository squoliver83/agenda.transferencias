<template>
    <table id="agendamento">
        <tr>
            <th>Id</th>
            <th>Conta Origem</th>
            <th>Conta Destino</th>
            <th class="double-column" colspan="2">Valor</th>
            <th class="double-column" colspan="2">Taxa</th>
            <th>Realizado em</th>
            <th>Agendado para</th>
        </tr>
        <tr :key="agendamento.id" v-for="agendamento in agendamentos">
            <Agendamento :agendamento="agendamento" />
        </tr>
    </table>
</template>

<script>
import Agendamento from './Agendamento'

export default {
    name: 'Agendamentos',
    props: {
        agendamentos: Array
    },
    components: {
        Agendamento
    },
}
</script>

<style scoped>

#agendamento {
    font-family: 'Poppins', sans-serif;
    border-collapse: collapse;
    border-radius: 7px;
    width: 100%;
    overflow: hidden;
}

#agendamento td, #agendamento th {
    border: 1px solid #ddd;
    padding: 8px;
}

.double-column {
    text-align: center;
}

th {
    background: #148163;
    color: white;
    font-weight: 400;
}

</style>
