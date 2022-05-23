package testtask.trelloclone.service.mapper;

import org.springframework.stereotype.Component;
import testtask.trelloclone.dto.request.ColumnsRequestDto;
import testtask.trelloclone.dto.response.ColumnsResponseDto;
import testtask.trelloclone.model.Column;
import testtask.trelloclone.service.ColumnService;

@Component
public class ColumnsMapper implements RequestDtoMapper<ColumnsRequestDto, Column>,
        ResponseDtoMapper<Column, ColumnsResponseDto> {
    private final ColumnService boardService;

    public ColumnsMapper(ColumnService boardService) {
        this.boardService = boardService;
    }

    @Override
    public Column mapToModel(ColumnsRequestDto columnsRequestDto) {
        Column column = new Column();
        column.setName(columnsRequestDto.getName());
        column.setOrder(columnsRequestDto.getOrder());
        column.setTask(columnsRequestDto.getTask());
        return column;
    }

    @Override
    public ColumnsResponseDto mapToDto(Column column) {
        ColumnsResponseDto columnsResponseDto = new ColumnsResponseDto();
        columnsResponseDto.setId(column.getId());
        columnsResponseDto.setName(column.getName());
        columnsResponseDto.setOrder(column.getOrder());
        columnsResponseDto.setTask(column.getTask());
        return columnsResponseDto;
    }
}
