package member.adapter.out.persistence

import example.adapter.out.persistence.MemberEntity
import example.domain.Member
import org.springframework.stereotype.Component

@Component
class MemberMapper {

    fun toMember(memberEntity: MemberEntity): Member {
        return Member(
            id = memberEntity.id!!,
            name = memberEntity.name,
            email = memberEntity.email,
            address = memberEntity.address,
            valid = memberEntity.valid,
            corp = memberEntity.corp
        )
    }

}