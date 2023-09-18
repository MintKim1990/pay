package example.application.port.out

import example.adapter.out.persistence.MemberEntity
import example.domain.Member

interface MemberCreatePort {
    fun createMember(name: String, address: String, email: String, isCorp: Boolean): Member
}