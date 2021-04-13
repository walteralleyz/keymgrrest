package br.com.zup.pix.read

import br.com.zup.AccountType
import br.com.zup.KeyType

data class AccountInfo(
    val name: String,
    val cpf: String,
    val bankName: String,
    val branch: String,
    val accountNumber: String,
    val accountType: AccountType
)

data class ReadResponse(
    val id: Int,
    val clientId: String,
    val pixType: KeyType,
    val pix: String,
    val createdAt: String,
    val accountInfo: AccountInfo
)