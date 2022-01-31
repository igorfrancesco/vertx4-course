package br.com.udemy.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  } // FIM DO MAIN

  @Override
  public void start(final Promise<Void> stVoidPromise) throws Exception{
    System.out.println("Start " + getClass().getName());
  }

}
