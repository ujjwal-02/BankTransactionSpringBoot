package com.example.UserBankAccount.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction_database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private Integer seq;

    public DatabaseSequence() {
    }

    public DatabaseSequence(String id, int seq) {
        this.id = id;
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "DatabaseSequence{" +
                "id='" + id + '\'' +
                ", seq=" + seq +
                '}';
    }

    //getters and setters omitted
}