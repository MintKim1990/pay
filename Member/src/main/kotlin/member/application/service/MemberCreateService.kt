package example.application.service

import example.application.UseCase
import example.application.port.`in`.MemberCreateUseCase
import example.application.port.`in`.command.MemberCreateCommand
import example.application.port.out.MemberCreatePort
import example.domain.Member
import member.adapter.out.persistence.MemberMapper
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
class MemberCreateService(
    private val memberCreatePort: MemberCreatePort,
) : MemberCreateUseCase {

    @Transactional
    override fun memberCreate(memberCreateCommand: MemberCreateCommand): Member {
        return memberCreatePort.createMember(
            name = memberCreateCommand.name,
            address = memberCreateCommand.address,
            email = memberCreateCommand.email,
            isCorp = memberCreateCommand.isCorp
        )
    }

}