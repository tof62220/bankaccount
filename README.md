# kata-bank-account-hexagonal

Hexagonal Bank account kata

Think of your personal bank account experience When in doubt, go for the simplest solution

## Requirements

Deposit and Withdrawal

Account statement (date, amount, balance)

Statement printing

## User Stories

### US 1:

In order to save money

As a bank client

I want to make a deposit in my account

> POST /v1.0/accounts/{accountId}/deposits/{amount}

### US 2:

In order to retrieve some or all of my savings

As a bank client

I want to make a withdrawal from my account

> POST v1.0/accounts/{accountId}/withdraws/{amount}

### US 3:

In order to check my operations

As a bank client

I want to see the history (operation, date, amount, balance)  of my operations

> GET v1.0/accounts/{accountId}/history

### US 4:

In order to check my operations

As a bank client

I want to print the history (operation, date, amount, balance)  of my operations

> GET v1.0/accounts/{accountId}/print


## Building

### What do you need
- Java 11
- Maven 3

### Launch tests

```bash
$ mvn test
```

### Build applilcation

```bash
$ mvn clean install
```

### Launch application

```bash
$ java -jar ./target/bankaccount-0.0.1-SNAPSHOT.jar
```

### Test Api

A default bank account with id=1 is created on application startup.
You can test apis with postman and the following examples :

#### Make a deposit 
```bash
http://localhost:8080/v1.0/accounts/1/deposits/2222.22
```

#### Make a withdraw 
```bash
http://localhost:8080/v1.0/accounts/1/withdraws/444.4444
```

#### Display history of operations 
```bash
http://localhost:8080/v1.0/accounts/1/history
```
#### Print of operations 
```bash
http://localhost:8080/v1.0/accounts/1/print
```


