package com.example.spring_security.dto;

public class DocumentDto {
    private String title;
    private boolean canUpload;
    private boolean canDelete;

    public DocumentDto(String title,
                       boolean canUpload,
                       boolean canDelete) {

        this.title = title;
        this.canUpload = canUpload;
        this.canDelete = canDelete;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCanUpload() {
        return canUpload;
    }

    public boolean isCanDelete() {
        return canDelete;
    }
}
