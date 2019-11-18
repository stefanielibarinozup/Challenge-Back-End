package br.com.zup.challenge.persistir.repository;

public interface ToInsert<T> {
    T insert(T t);
}
