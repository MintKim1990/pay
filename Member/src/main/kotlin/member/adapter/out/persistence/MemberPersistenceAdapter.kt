package example.adapter.out.persistence

import common.PersistenceAdapter
import example.application.port.out.MemberCreatePort
import example.application.port.out.MemberFindPort
import example.domain.Member
import member.adapter.out.persistence.MemberMapper
import member.application.port.out.MemberModifyPort
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository,
    private val memberMapper: MemberMapper,
) : MemberCreatePort, MemberFindPort, MemberModifyPort {

    override fun createMember(name: String, address: String, email: String, isCorp: Boolean): Member {

        val memberEntity = MemberEntity(
            name = name,
            email = email,
            address = address,
            corp = isCorp
        )

        memberRepository.save(memberEntity)
        return memberMapper.toMember(memberEntity);
    }

    override fun findMember(id: Long): Member {
        val memberEntity = memberRepository.findByIdOrNull(id) ?: throw NoSuchElementException()
        return memberMapper.toMember(memberEntity)
    }

    override fun modifyMember(id: Long, name: String, address: String, email: String): Member {
        val memberEntity = memberRepository.findByIdOrNull(id) ?: throw NoSuchElementException()
        memberEntity.modify(name = name, email = email, address = address)
        return memberMapper.toMember(memberEntity)
    }

}