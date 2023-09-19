package bank.domain

class Member(
    var id: Long,
    var name: String,
    var email: String,
    var address: String,
    var valid: Boolean,
    var corp: Boolean,
)