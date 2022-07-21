package com.guxo.crmbackend.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;

class OpenAPISecurityConfigurationTest {
    /**
     * Method under test: {@link OpenAPISecurityConfiguration#customizeOpenAPI()}
     */
    @Test
    void testCustomizeOpenAPI() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by customizeOpenAPI()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        OpenAPI actualCustomizeOpenAPIResult = (new OpenAPISecurityConfiguration()).customizeOpenAPI();
        assertNull(actualCustomizeOpenAPIResult.getTags());
        assertNull(actualCustomizeOpenAPIResult.getExtensions());
        assertNull(actualCustomizeOpenAPIResult.getInfo());
        assertNull(actualCustomizeOpenAPIResult.getServers());
        assertEquals("3.0.1", actualCustomizeOpenAPIResult.getOpenapi());
        assertNull(actualCustomizeOpenAPIResult.getExternalDocs());
        assertNull(actualCustomizeOpenAPIResult.getPaths());
        assertEquals(1, actualCustomizeOpenAPIResult.getSecurity().size());
        Components components = actualCustomizeOpenAPIResult.getComponents();
        assertNull(components.getExtensions());
        assertNull(components.getExamples());
        assertNull(components.getRequestBodies());
        assertNull(components.getCallbacks());
        assertNull(components.getSchemas());
        assertNull(components.getLinks());
        assertNull(components.getParameters());
        assertNull(components.getResponses());
        assertEquals(1, components.getSecuritySchemes().size());
        assertNull(components.getHeaders());
    }
}

