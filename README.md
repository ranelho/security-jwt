# Spring Boot, Spring Security, PostgreSQL: JWT Authentication & Authorization example - Refactored by: Ranelho Lacerda
# Código Original: https://www.bezkoder.com/spring-boot-security-postgresql-jwt-authentication/
# Adapação para Necessidade e implementação de métodos, POST's, GET's, REFRESHTOKEN.

## Cadastro de Usuário, Login de Usuário e Processo de Autorização.
O diagrama mostra o fluxo de como implementamos o processo de Registro de Usuário, Login de Usuário e Autorização.

![spring-boot-spring-security-postgresql-jwt-authentication-flow](spring-boot-spring-security-postgresql-jwt-authentication-flow.png)

## Arquitetura do Spring Boot Server com Spring Security
Você pode ter uma visão geral do nosso Spring Boot Server com o diagrama abaixo:

![spring-boot-spring-security-postgresql-jwt-authentication-architecture](spring-boot-spring-security-postgresql-jwt-authentication-architecture.png)

## Para mais detalhes, visite:
> [Spring Boot, Spring Security, PostgreSQL: JWT Authentication & Authorization example](https://bezkoder.com/spring-boot-security-postgresql-jwt-authentication/)

> [For MySQL](https://bezkoder.com/spring-boot-jwt-authentication/)

> [For MongoDB](https://bezkoder.com/spring-boot-jwt-auth-mongodb/)

## Refresh Token

![spring-boot-refresh-token-jwt-example-flow](spring-boot-refresh-token-jwt-example-flow.png)

Para instrução: [Spring Boot Refresh Token with JWT example](https://bezkoder.com/spring-boot-refresh-token-jwt/)

## Mais prática:
> [Spring Boot File upload example with Multipart File](https://bezkoder.com/spring-boot-file-upload/)

> [Exception handling: @RestControllerAdvice example in Spring Boot](https://bezkoder.com/spring-boot-restcontrolleradvice/)

> [Spring Boot Repository Unit Test with @DataJpaTest](https://bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/)

> [Spring Boot Pagination & Sorting example](https://www.bezkoder.com/spring-boot-pagination-sorting-example/)

Associações:
> [Spring Boot One To Many example with Spring JPA, Hibernate](https://www.bezkoder.com/jpa-one-to-many/)

> [Spring Boot Many To Many example with Spring JPA, Hibernate](https://www.bezkoder.com/jpa-many-to-many/)

> [JPA One To One example with Spring Boot](https://www.bezkoder.com/jpa-one-to-one/)

Execute o Backend e o Frontend em um só lugar:
> [Integrate Angular with Spring Boot Rest API](https://bezkoder.com/integrate-angular-spring-boot/)

> [Integrate React.js with Spring Boot Rest API](https://bezkoder.com/integrate-reactjs-spring-boot/)

> [Integrate Vue.js with Spring Boot Rest API](https://bezkoder.com/integrate-vue-spring-boot/)

## Dependency
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
		
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
		
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
		
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.1</version>
</dependency>
```