package member.application.service

import example.application.UseCase
import example.application.port.`in`.command.MemberModifyCommand
import example.application.service.MemberMapper
import example.domain.Member
import member.application.port.`in`.MemberModifyUseCase
import member.application.port.out.MemberModifyPort
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
class MemberModifyService(
    private val memberModifyPort: MemberModifyPort,
    private val memberMapper: MemberMapper
) : MemberModifyUseCase {

    override fun memberModify(memberModifyCommand: MemberModifyCommand): Member {
        val memberEntity = memberModifyPort.modifyMember(
            id = memberModifyCommand.id,
            name = memberModifyCommand.name,
            address = memberModifyCommand.address,
            email = memberModifyCommand.email
        )

        return memberMapper.toMember(memberEntity)
    }

}