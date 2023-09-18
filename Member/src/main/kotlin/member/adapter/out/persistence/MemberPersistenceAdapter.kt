package example.adapter.out.persistence

import common.PersistenceAdapter
import example.application.port.out.MemberCreatePort
import example.application.port.out.MemberFindPort
import member.application.port.out.MemberModifyPort
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository,
) : MemberCreatePort, MemberFindPort, MemberModifyPort {

    override fun createMember(name: String, address: String, email: String, isCorp: Boolean): MemberEntity {

        val memberEntity = MemberEntity(
            name = name,
            email = email,
            address = address,
            corp = isCorp
        )

        return memberRepository.save(memberEntity)
    }

    override fun findMember(id: Long): MemberEntity {
        return memberRepository.findByIdOrNull(id) ?: throw NoSuchElementException()
    }

    override fun modifyMember(id: Long, name: String, address: String, email: String): MemberEntity {
        val memberEntity = memberRepository.findByIdOrNull(id) ?: throw NoSuchElementException()
        memberEntity.modify(name = name, email = email, address = address)
        return memberEntity
    }

}