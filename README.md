# 📱 SMS API

Esta é uma API REST desenvolvida em Java com Spring Boot para gestão e envio de mensagens SMS. O projeto permite o registo de mensagens, atualização de status e geração de relatórios de mensagens enviadas nas últimas 24 horas.

## 🛠️ Tecnologias
* Java 17
* Spring Boot
* PostgreSQL
* Lombok

## 🚀 Como usar
1. Crie o banco `db_sms` no seu PostgreSQL.
2. Configure seu usuário e senha no `application.properties`.
3. Rode a aplicação (Porta: `8086`).

## 🗺️ Endpoints
- **POST** `/message` : Envia um SMS.
- **PATCH** `/message/{id}?status=RECEBIDO` : Atualiza o status.
- **GET** `/message/relatorio?status=RECEBIDO` : Lista as mensagens enviadas nas últimas 24h.

### Exemplo de JSON (POST):
```json
{
  "message": "Teste de API",
  "phoneNumber": "11999999999"
}
```

---

☕ Desenvolvido por [Diego Duarte](https://github.com/dduartetech)
