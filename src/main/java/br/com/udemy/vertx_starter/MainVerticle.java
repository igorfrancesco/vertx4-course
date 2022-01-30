package br.com.udemy.vertx_starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    var vertx= Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/html; charset=utf-8")
        .end("Olá Mundo!");
    }).listen(9000, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server iniciou na porta 9000");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
