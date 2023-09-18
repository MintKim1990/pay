package member.application.port.out

import example.adapter.out.persistence.MemberEntity

interface MemberModifyPort {
    fun modifyMember(id: Long, name: String, address: String, email: String): MemberEntity
}