package example.adapter.`in`.web

import common.WebAdapter
import example.application.port.`in`.MemberFindUseCase
import example.application.port.`in`.command.MemberFindCommand
import example.domain.Member
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@WebAdapter(path = "/member")
class MemberFindController(
    private val memberFindUseCase: MemberFindUseCase
) {

    @GetMapping("/{id}")
    fun memberFind(@PathVariable id: Long): ResponseEntity<Member> {
        val memberFindCommand = MemberFindCommand(id)
        val findMember = memberFindUseCase.memberFind(memberFindCommand)
        return ResponseEntity.ok(findMember)
    }

}