package bank.application.port.out

import bank.adapter.out.bank.model.FirmBankReqeust
import bank.adapter.out.bank.model.FirmBankResponse

interface FirmBankRequestPort {
    fun request(firmBankReqeust: FirmBankReqeust): FirmBankResponse
}