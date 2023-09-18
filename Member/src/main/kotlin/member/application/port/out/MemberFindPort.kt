package example.application.port.out

import example.adapter.out.persistence.MemberEntity
import example.domain.Member

interface MemberFindPort {
    fun findMember(id: Long): Member
}