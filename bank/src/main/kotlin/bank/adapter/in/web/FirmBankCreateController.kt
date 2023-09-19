package bank.adapter.`in`.web

import bank.adapter.`in`.web.model.FirmBankCreateRequest
import bank.application.port.`in`.FirmBankCreateUseCase
import bank.application.port.`in`.command.FirmBankRequestCommand
import bank.domain.FirmBank
import common.WebAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@WebAdapter(path = "/firmbank")
class FirmBankCreateController(
    private val firmBankCreateUseCase: FirmBankCreateUseCase
) {

    @PostMapping
    fun request(@RequestBody firmBankCreateRequest: FirmBankCreateRequest): ResponseEntity<FirmBank> {
        val firmBankRequestCommand = FirmBankRequestCommand(
            fromBankName = firmBankCreateRequest.fromBankName,
            fromAccountNumber = firmBankCreateRequest.fromAccountNumber,
            toBankName = firmBankCreateRequest.toBankName,
            toAccountNumber = firmBankCreateRequest.toAccountNumber,
            money = firmBankCreateRequest.money
        )

        val firmBank = firmBankCreateUseCase.request(firmBankRequestCommand)
        return ResponseEntity.ok(firmBank)
    }

}