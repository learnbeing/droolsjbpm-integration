package org.kie.remote.services.rest.jaxb;

import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import org.apache.deltaspike.core.api.provider.BeanManagerProvider;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * We use this class in order to use (user) classes from Kjar deployments in serialization.
 * </p>
 * Users may send inputs to the REST API that contain instances of these classes as parameters to {@link KieSession} operations.
 */
@Provider
public class JaxbContextResolver implements ContextResolver<JAXBContext> {

    private static final Logger logger = LoggerFactory.getLogger(JaxbContextResolver.class);

    @Inject
    DynamicJaxbContext dynamicContext;

    @PostConstruct
    public void configure() {
        if (dynamicContext == null) {
            logger.info("JaxbContextResolver does not support CDI injection, looking up DynamicJaxbContext programmatically");
            BeanManager beanManager = BeanManagerProvider.getInstance().getBeanManager();
            try {
                Set<Bean<?>> beans = beanManager.getBeans( DynamicJaxbContext.class );

                if (beans != null && !beans.isEmpty()) {
                    Bean<?> bean = (Bean<?>) beans.iterator().next();

                    dynamicContext = (DynamicJaxbContext) beanManager.getReference(bean, DynamicJaxbContext.class,
                                                          beanManager.createCreationalContext(bean));
                }

            } catch (Exception e) {
                logger.warn("Unable to retrieve DynamicJaxbContext programmatically from cdi container due to {}", e.getMessage());
            }
        }
    }

    @Override
    public JAXBContext getContext(Class<?> type) {

        return dynamicContext;
    }

}
