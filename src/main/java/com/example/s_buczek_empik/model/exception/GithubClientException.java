package com.example.s_buczek_empik.model.exception;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

public class GithubClientException extends RuntimeException {

    public GithubClientException() {
        super("Github client exception occurred.");
    }
}
