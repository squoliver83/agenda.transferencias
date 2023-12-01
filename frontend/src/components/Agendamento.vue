<template>
    <td>{{ agendamento.id }}</td>
    <td>{{ agendamento.contaOrigem }}</td>
    <td>{{ agendamento.contaDestino }}</td>
    <td class="currency">R$</td>
    <td class="value">{{ agendamento.valor }}</td>
    <td class="currency">R$</td>
    <td class="value">{{ agendamento.taxa }}</td>
    <td>{{ getFormattedDate(agendamento.data) }}</td>
    <td>{{ getFormattedDate(agendamento.dataTransferencia) }}</td>
</template>

<script> 
import { useDateFormat } from '@vueuse/core'

export default {
    name: 'Agendamento',
    props: {
        agendamento: Object
    },
    methods: {
        getFormattedDate(date) {
            return useDateFormat(date, 'DD-MM-YYYY').value
        }
    }
}
</script>

<style scope>

td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
}

tr:hover {
    background-color: #dfc762;
}

.fas {
    color: red;
}

.currency {
    text-align: left; 
    border-right: none;
}

.value {
    text-align: right; 
    border-left: none;
}

.agendamento {
    background: #DDD;
    margin: 5px;
    padding: 10px 20px;
    cursor: pointer;
}

.agendamento h3 {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

</style>