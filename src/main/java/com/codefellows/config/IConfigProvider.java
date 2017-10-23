package com.codefellows.config;

@FunctionalInterface
public interface IConfigProvider {
    Config provide(Class className);
}
