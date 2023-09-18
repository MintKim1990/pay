package example.application.service

import example.application.UseCase
import example.application.port.`in`.MemberFindUseCase
import example.application.port.`in`.command.MemberFindCommand
import example.application.port.out.MemberFindPort
import example.domain.Member
import member.adapter.out.persistence.MemberMapper
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
class MemberFindService(
    private val memberFindPort: MemberFindPort,
) : MemberFindUseCase {

    override fun memberFind(memberFindCommand: MemberFindCommand): Member {
        return memberFindPort.findMember(memberFindCommand.id)
    }

}