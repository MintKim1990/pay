package member.application.service

import example.application.UseCase
import example.application.port.`in`.command.MemberModifyCommand
import member.adapter.out.persistence.MemberMapper
import example.domain.Member
import member.application.port.`in`.MemberModifyUseCase
import member.application.port.out.MemberModifyPort
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
class MemberModifyService(
    private val memberModifyPort: MemberModifyPort,
) : MemberModifyUseCase {

    override fun memberModify(memberModifyCommand: MemberModifyCommand): Member {
        return memberModifyPort.modifyMember(
            id = memberModifyCommand.id,
            name = memberModifyCommand.name,
            address = memberModifyCommand.address,
            email = memberModifyCommand.email
        )
    }

}