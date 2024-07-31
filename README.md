# FiveChan
___

## Integrantes
- Fabricio Jesús Huaquisto Quispe
- Erick Malcoaccha Diaz
- Marko Sumire Ramos
- Christian Taipe Saraza
- Alonso Chullunquia Rosas
- Sergio Castillo


### Erick Malcoaccha
#### Clean Code

##### 1. Nombrado Significativo

Los nombres de las clases y métodos son claros y descriptivos.

**Ejemplo:**

```java
public class UserEntity {
    @Id
    private UUID id;
    private String name;
    private String description;
    private String avatar;
    private String email;

    // Métodos
}
```
##### 2. Funciones Pequeñas y Centradas
Cada método realiza una tarea específica, lo que facilita su comprensión y mantenimiento.

```java
@Override
@Transactional
public void save(User user) {
    UserEntity userEntity = UserEntity.fromDomain(user);
    entityManager.persist(userEntity);
}

@Override
public User findById(UUID id) {
    UserEntity userEntity = entityManager.find(UserEntity.class, id);
    return userEntity != null ? userEntity.toDomain() : null;
}

```
##### 3. Evitar commentarios inncesarios
El código es autoexplicativo, lo que minimiza la necesidad de comentarios adicionales.

```java
@Override
public User findByUsername(String username) {
    try {
        UserEntity userEntity = entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.name = :username", UserEntity.class)
                .setParameter("username", username)
                .getSingleResult();
        return userEntity.toDomain();
    } catch (jakarta.persistence.NoResultException e) {
        return null;
    }
}

```

#### Solid
#### Styles of programming