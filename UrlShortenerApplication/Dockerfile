# base image to build a JRE
FROM alpine:latest AS builder

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk
ENV PATH=$PATH:$JAVA_HOME/bin
 
# Install OpenJDK
RUN apk add --no-cache \
    java-cacerts \
    openjdk17-jdk \
    binutils
 
# Build small JRE image
RUN $JAVA_HOME/bin/jlink \
    --verbose \
    --add-modules  java.compiler,java.base,java.management,java.naming,java.net.http,java.security.jgss,java.security.sasl,java.sql,jdk.httpserver,jdk.unsupported,java.xml,java.sql,java.prefs,java.desktop,java.instrument \
    --strip-debug \
    --no-man-pages \
    --no-header-files \
    --compress=2 \
    --output /customjre
 

# =========================
# Runtime stage
# =========================

# Final image
FROM alpine:latest

ENV JAVA_HOME=/opt/jre
ENV PATH="$JAVA_HOME/bin:$PATH"

 
# Copy the custom jre from the builder stage
COPY --from=builder /customjre $JAVA_HOME

EXPOSE 8080
ADD target/url-service.jar url-service.jar
ENTRYPOINT ["java","-jar","./url-service.jar"]