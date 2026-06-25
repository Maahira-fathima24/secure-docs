package com.example.spring_security.model;

import jakarta.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documentName;

    @Column(length = 5000)
    private String content;

    @Enumerated(EnumType.STRING)
    private Role requiredRole;

    public Document() {
    }

    public Document(String documentName,
                    String content,
                    Role requiredRole) {
        this.documentName = documentName;
        this.content = content;
        this.requiredRole = requiredRole;
    }

    public Long getId() {
        return id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Role getRequiredRole() {
        return requiredRole;
    }

    public void setRequiredRole(Role requiredRole) {
        this.requiredRole = requiredRole;
    }
}
