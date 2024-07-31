# Proyecto Fivechan

## Estilos de Programación Usados

En este proyecto, hemos aplicado varios estilos de programación para mejorar la claridad, la mantenibilidad y la robustez del código. A continuación, se describen los estilos de programación utilizados y cómo se han implementado en el proyecto:

### Pipeline Style en Comment.java

El estilo Pipeline organiza el procesamiento de datos en una serie de pasos secuenciales. En `Comment.java`, hemos utilizado este estilo para validar, sanitizar y guardar un comentario. Este enfoque permite encadenar métodos de manera fluida y asegura que cada paso del procesamiento se ejecute en el orden correcto.

#### Código:
```java
package com.fivechan.forum.context.comment.domain;

import java.util.UUID;

public class Comment {
    private UUID id;
    private UUID userId;
    private UUID topicId;
    private String content;

    public Comment(UUID id, UUID userId, UUID topicId, String content) {
        this.id = id;
        this.userId = userId;
        this.topicId = topicId;
        this.content = content;
    }

    public Comment(UUID userId, UUID topicId, String content) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.topicId = topicId;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Pipeline style methods

    public Comment validate() {
        // Step 1: Validate comment
        if (userId == null || topicId == null || content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid comment data");
        }
        return this;
    }

    public Comment sanitize() {
        // Step 2: Sanitize comment content
        this.content = this.content.replaceAll("<[^>]*>", ""); // Remove HTML tags
        return this;
    }

    public Comment save() {
        // Step 3: Save comment
        // Simulate saving to a database
        System.out.println("Comment saved: " + this);
        return this;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", topicId=" + topicId +
                ", content='" + content + '\'' +
                '}';
    }
}
```
### Error Handling en `CommentController.java`

**Descripción:**
El manejo de errores y excepciones implica capturar y gestionar errores de manera controlada, devolviendo respuestas significativas y adecuadas al cliente. En `CommentController.java`, se añadieron bloques `try-catch` en los métodos de la API para capturar excepciones y devolver respuestas HTTP apropiadas. Esto garantiza que cualquier error se gestione adecuadamente y se informe a los usuarios de manera clara.

**Implementación:**

En cada método del controlador, se han añadido bloques `try-catch` para capturar excepciones específicas como `IllegalArgumentException` y excepciones generales. Esto asegura que se manejen adecuadamente los errores y se devuelvan respuestas HTTP 400 para argumentos no válidos y 500 para errores del servidor.

```java
package com.fivechan.forum.context.comment.application;

import com.fivechan.forum.context.comment.domain.Comment;
import com.fivechan.forum.context.comment.domain.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
        initialize();
    }

    public void initialize() {
        loadConfigurations();
        initializeComponents();
        startServices();
    }

    private void loadConfigurations() {
        // Implementation for loading configurations
    }

    private void initializeComponents() {
        // Implementation for initializing components
    }

    private void startServices() {
        // Implementation for starting services
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody CommentDTO commentDTO) {
        try {
            commentService.createComment(commentDTO);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error");
        }
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        try {
            List<Comment> comments = commentService.getAllComments();
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable UUID id) {
        try {
            Comment comment = commentService.getCommentById(id);
            return ResponseEntity.ok(comment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable UUID id, @RequestBody CommentDTO commentDTO) {
        try {
            commentService.updateComment(id, commentDTO);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable UUID id) {
        try {
            commentService.deleteComment(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error");
        }
    }
}
```
### Cookbook Style en `CommentController.java`

**Descripción:**
El estilo Cookbook implica dividir el código en una serie de pasos claramente definidos y secuenciales. En `CommentController.java`, hemos utilizado este estilo para la inicialización del controlador. Cada paso está claramente definido en métodos separados que se llaman en orden durante la inicialización.

**Implementación:**
En el constructor de `CommentController`, se llama al método `initialize()`, que a su vez llama a los métodos `loadConfigurations()`, `initializeComponents()`, y `startServices()` en orden secuencial.

**Código:**
```java
package com.fivechan.forum.context.comment.application;

import com.fivechan.forum.context.comment.domain.Comment;
import com.fivechan.forum.context.comment.domain.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
        initialize();
    }

    public void initialize() {
        loadConfigurations();
        initializeComponents();
        startServices();
    }

    private void loadConfigurations() {
        // Implementation for loading configurations
    }

    private void initializeComponents() {
        // Implementation for initializing components
    }

    private void startServices() {
        // Implementation for starting services
    }

    @PostMapping
    public void createComment(@RequestBody CommentDTO commentDTO) {
        commentService.createComment(commentDTO);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable UUID id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable UUID id, @RequestBody CommentDTO commentDTO) {
        commentService.updateComment(id, commentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable UUID id) {
        commentService.deleteComment(id);
    }
}
```
