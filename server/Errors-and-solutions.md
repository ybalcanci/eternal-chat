### 1)
JSON data is written in page so many times despite I had only 2 objects.
I added @JsonIgnore annotation to the head of @ManyToOne relation in my model class to resolve this.
##### Caused problem 5

### 2)
I was using @Controller for my controller class but when I wanted to send JSON data as response, 
I got error.
This problem was resolved when I replaced @Controller with @RestController.

### 3)
When I used 

```
Stream.of("sa napyon", "as iyi sen").forEach(text ->{
	Message message = new Message(text);
	message.setSender(user);
	user.getMessages().add(message);
	userRepository.save(user);
	messageRepository.save(message);
});
```
the messageRepository had 3 messages (2nd message is recorded twice) instead of 2.
Because I had
```
@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private Set<Message> messages = new HashSet<>();
```
"If you have a cascade ALL type then you dont need to save your child entity first, just the parent."
https://stackoverflow.com/questions/26014217/spring-data-jpa-entity-created-twice

### 4)
React client could not get data from the server with an error saying
"Access-Control-Allow-Origin needed"
The problem was resolved when I added 
```
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
```
to the head of related mapping method.

### 5)
I wanted to send user data regarding messages but I could not because of @JsonIgnore annotation.
This problem was resolved when I added 
```
@JsonBackReference
```
prior to "messages" reference in User class and
```
@JsonManagedReference
```
prior to "sender" reference in Message class after removing @JsonIgnore.

##### Caused problem 6
### 6)
When I wanted to send data to server via POST request, I got the error
```
.c.j.MappingJackson2HttpMessageConverter : Failed to evaluate Jackson deserialization for type [[simple type, class 
com.ybalcanci.eternalchat.model.Message]]: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot handle managed/back reference 'defaultReference': back 
reference type (java.util.Set) not compatible with managed type (com.ybalcanci.eternalchat.model.Message)
```
which was fixed when I removed
```
@JsonManagedReference
```
from Messages class.
https://stackoverflow.com/questions/28179369/spring-rest-json-can-not-handle-managed-back-reference-defaultreference-415/28210464

### 7)
