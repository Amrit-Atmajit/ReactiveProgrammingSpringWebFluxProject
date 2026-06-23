package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxMonoGeneratorService {

    private Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .log();
    }

    private Mono<String> namesMono() {
        return Mono.just("amrit")
                .log();
    }

    public static void main(String[] args) {
        var service = new FluxMonoGeneratorService();

        // Calls Flux subscribe method
        service.namesFlux()
                .parallel()
                .subscribe(name -> System.out.println("Flux Name is : " + name));

        // Calls Mono subscribe method
        service.namesMono().subscribe(name -> System.out.println("Mono name is : " + name));
    }
}
