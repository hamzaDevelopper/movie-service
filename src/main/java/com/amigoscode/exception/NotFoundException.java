package com.amigoscode.exception;

import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
