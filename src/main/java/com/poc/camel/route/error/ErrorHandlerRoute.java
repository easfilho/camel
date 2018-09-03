package com.poc.camel.route.error;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class ErrorHandlerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        onException(RuntimeException.class)
                .log(LoggingLevel.WARN, "Lançou RuntimeException");

        errorHandler(defaultErrorHandler()
            .maximumRedeliveries(2)
            .redeliveryDelay(3000)
            .backOffMultiplier(2)
            .retryAttemptedLogLevel(LoggingLevel.WARN)
            .log("[Ocorreu um erro]")
        );

        from("direct:sampleInput")
                .log("Mensagem Recebida: ${body} Headers: ${headers}")
                .process(this::lancarExcecao)
                .to("log:${body}");
    }

    private void lancarExcecao(Exchange exchange) {
        throw new RuntimeException("exceção");
    }
}
