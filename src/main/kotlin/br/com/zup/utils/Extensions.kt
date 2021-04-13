package br.com.zup.utils

import br.com.zup.KeymgrExcludeResponse
import br.com.zup.KeymgrReadAllResponse
import br.com.zup.KeymgrReadResponse
import br.com.zup.KeymgrRegistryResponse
import br.com.zup.pix.all.AllResponse
import br.com.zup.pix.all.Response
import br.com.zup.pix.read.AccountInfo
import br.com.zup.pix.read.ReadResponse
import br.com.zup.pix.registry.RegistryResponse
import br.com.zup.pix.remove.RemoveResponse

fun KeymgrRegistryResponse.toAPIResponse() = RegistryResponse(this.id)

fun KeymgrExcludeResponse.toAPIResponse() = RemoveResponse(this.pix, this.clientId)

fun KeymgrReadResponse.toAPIResponse() = ReadResponse(
    this.id,
    this.clientId,
    this.pixType,
    this.pix,
    this.createdAt,
    AccountInfo(
        this.accountInfo.name,
        this.accountInfo.cpf,
        this.accountInfo.bankName,
        this.accountInfo.branch,
        this.accountInfo.accountNumber,
        this.accountInfo.accountType
    )
)

fun KeymgrReadAllResponse.toAPIResponse(): AllResponse {
    return this.responseList.map {
        Response(it.id, it.clientId, it.keyType, it.pix, it.accountType, it.createdAt)
    }.toTypedArray().let { responseList -> AllResponse(responseList) }
}