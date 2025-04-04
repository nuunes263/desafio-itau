package controller;

import dto.TransactionRequestDto;
import jakarta.validation.Valid;
import model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.TransactionService;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    public final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTRansaction (@Valid @RequestBody TransactionRequestDto request){
        if (request.getDataHora().isAfter(OffsetDateTime.now())){
            return ResponseEntity.unprocessableEntity().build();
        }

        transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
