package example.application.port.out

import bank.domain.Member

interface MemberFindPort {
    fun findMember(id: Long): Member?
}