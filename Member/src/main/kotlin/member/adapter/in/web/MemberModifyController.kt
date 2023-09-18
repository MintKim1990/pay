package member.adapter.`in`.web

import common.WebAdapter
import example.adapter.`in`.web.request.MemberModifyRequest
import example.application.port.`in`.command.MemberModifyCommand
import example.domain.Member
import member.application.port.`in`.MemberModifyUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@WebAdapter(path = "/member")
class MemberModifyController(
    private val memberModifyUseCase: MemberModifyUseCase
) {

    @PutMapping("/{id}")
    fun memberModify(
        @PathVariable id: Long,
        @RequestBody memberModifyRequest: MemberModifyRequest
    ): ResponseEntity<Member> {

        val memberModifyCommand = MemberModifyCommand(
            id = id,
            name = memberModifyRequest.name,
            address = memberModifyRequest.address,
            email = memberModifyRequest.email
        )

        val member = memberModifyUseCase.memberModify(memberModifyCommand)
        return ResponseEntity.ok(member)
    }

}