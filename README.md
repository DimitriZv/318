## Create/update customer contact

## Demonstration: Sample REST Requests

Show all contacts from Seed Data:
http://localhost:8080/contacts/
```bash
{
  "_embedded": {
    "contactList": [
      {
        "id": 1,
        "firstName": "Bilbo",
        "lastName": "Baggins",
        "phone": "123456987",
        "email": "bil@bibl.bil",
        "position": "burglar",
        "name": "Bilbo Baggins",
        "_links": {
          "self": {
            "href": "http://localhost:8080/contacts/1"
          },
          "contacts": {
            "href": "http://localhost:8080/contacts"
          }
        }
      },
      {
        "id": 2,
        "firstName": "Frodo",
        "lastName": "Baggins",
        "phone": "236589956",
        "email": "frod@frod.fr",
        "position": "thief",
        "name": "Frodo Baggins",
        "_links": {
          "self": {
            "href": "http://localhost:8080/contacts/2"
          },
          "contacts": {
            "href": "http://localhost:8080/contacts"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/contacts"
    }
  }
}
```

## create a new contact:
```bash
curl -v -X POST localhost:8080/contacts -H 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "email": "sam@sam.sm", "position": "gardener"}'
```
which returns
```bash
{
  "id": 3,
  "firstName": "Samwise",
  "lastName": "Gamgee",
  "phone": null,
  "email": "sam@sam.sm",
  "position": "gardener",
  "name": "Samwise Gamgee",
  "_links": {
    "self": {
      "href": "http://localhost:8080/contacts/3"
    },
    "contacts": {
      "href": "http://localhost:8080/contacts"
    }
  }
}
```

## update a contact:
```bash
curl -X PUT localhost:8080/contacts/3 -H 'Content-type:application/json' -d '{"name": "Updated Contact", "phone":"888888888","email": "new@email.new", "position": "New Potistion"}'
```
which returns
```bash
{
  "id": 3,
  "firstName": "Updated",
  "lastName": "Contact",
  "phone": "888888888",
  "email": "new@email.new",
  "position": "New Potistion",
  "name": "Updated Contact",
  "_links": {
    "self": {
      "href": "http://localhost:8080/contacts/3"
    },
    "contacts": {
      "href": "http://localhost:8080/contacts"
    }
  }
}
```

## delete a contact:
```bash
curl -X DELETE localhost:8080/contacts/3
http://localhost:8080/contacts/3
curl -X DELETE localhost:8080/contacts/2
http://localhost:8080/contacts/2

http://localhost:8080/contacts/
```
which returns
```bash
No body return for response
Could not find contact 2
No body return for response
Could not find contact 3

{
  "_embedded": {
    "contactList": [
      {
        "id": 1,
        "firstName": "Bilbo",
        "lastName": "Baggins",
        "phone": "123456987",
        "email": "bil@bibl.bil",
        "position": "burglar",
        "name": "Bilbo Baggins",
        "_links": {
          "self": {
            "href": "http://localhost:8080/contacts/1"
          },
          "contacts": {
            "href": "http://localhost:8080/contacts"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/contacts"
    }
  }
}
```
