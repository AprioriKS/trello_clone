package testtask.trelloclone.service.mapper;

public interface ResponseDtoMapper<T, D> {
    D mapToDto(T t);
}
