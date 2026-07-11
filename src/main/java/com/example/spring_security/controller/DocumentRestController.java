package com.example.spring_security.controller;
import com.example.spring_security.dto.DocumentDto;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentRestController {

    @GetMapping("/api/documents")
    public List<DocumentDto> getDocuments(Authentication authentication) {

        String role = authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority();

        List<DocumentDto> docs = new ArrayList<>();

        if (role.equals("ROLE_ADMIN")) {

            docs.add(new DocumentDto(
                    "Admin Report.pdf",
                    true,
                    true
            ));

            docs.add(new DocumentDto(
                    "Employee Database.xlsx",
                    true,
                    true
            ));

            docs.add(new DocumentDto(
                    "Audit Report.pdf",
                    true,
                    true
            ));
        }

        else if (role.equals("ROLE_MANAGER")) {

            docs.add(new DocumentDto(
                    "Team Report.pdf",
                    true,
                    false
            ));

            docs.add(new DocumentDto(
                    "Meeting Minutes.pdf",
                    true,
                    false
            ));
        }

        else {

            docs.add(new DocumentDto(
                    "Salary Slip.pdf",
                    false,
                    false
            ));

            docs.add(new DocumentDto(
                    "Public Notice.pdf",
                    false,
                    false
            ));
        }

        return docs;
    }
}
