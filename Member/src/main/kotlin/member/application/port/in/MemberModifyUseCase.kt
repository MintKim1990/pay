package member.application.port.`in`

import example.application.port.`in`.command.MemberModifyCommand
import example.domain.Member

interface MemberModifyUseCase {
    fun memberModify(memberModifyCommand: MemberModifyCommand): Member
}