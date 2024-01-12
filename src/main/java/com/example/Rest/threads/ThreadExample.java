package com.example.Rest.threads;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Service
public class ThreadExample {


    public void executorService() {
        int numberOfThreads = 2;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        try {
            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                    CompletableFuture.runAsync(() -> generateEvenAndOddNumbers(0), executorService),
                    CompletableFuture.runAsync(() -> generateEvenAndOddNumbers(1), executorService)
            );

            // This will keep the threads running indefinitely
            allFutures.join();

        } finally {
            executorService.shutdown();
        }
    }

    private static void generateEvenAndOddNumbers(int threadId) {
        System.out.println("Thread " + threadId + " is generating even and odd numbers indefinitely:");

        int i = 0;

        while (true) {
            if (i % 2 == 0) {
                System.out.println("Thread " + threadId + " - Even Number: " + i);
            } else {
                System.out.println("Thread " + threadId + " - Odd Number: " + i);
            }

            i++;

            // Introducing a delay to make it easier to observe
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
