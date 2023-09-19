package bank.adapter.out.member

import bank.domain.Member
import common.Adapter
import example.application.port.out.MemberFindPort
import org.springframework.web.client.RestTemplate

@Adapter
class MemberFindAdapter(
    private val restTemplate: RestTemplate
) : MemberFindPort {

    companion object {
        val MEMBER_FIND_URL = "localhost:8080/member/"
    }

    override fun findMember(id: Long): Member? {
        return restTemplate.getForEntity(MEMBER_FIND_URL + id, Member::class.java).body
    }
}