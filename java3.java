public class GroupStream implements Iterable<Group> {
    private List<Group> groups;

    public GroupStream(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public Iterator<Group> iterator() {
        return groups.iterator();
    }
}

import java.util.Comparator;

public class StreamComparator implements Comparator<GroupStream> {
    @Override
    public int compare(GroupStream o1, GroupStream o2) {
        return Integer.compare(o1.groups.size(), o2.groups.size());
    }
}

import java.util.Collections;
import java.util.List;

public class StreamService {
    public void sortStreams(List<GroupStream> streams) {
        Collections.sort(streams, new StreamComparator());
    }
}

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final StreamService streamService;

    public Controller(StreamService streamService) {
        this.streamService = streamService;
    }

    public void sortStreams(List<GroupStream> streams) {
        streamService.sortStreams(streams);
    }
}

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем список учебных групп
        List<Group> groups = Arrays.asList(new Group("A"), new Group("B"));
        GroupStream groupStream = new GroupStream(groups);

        // Создаем список потоков
        List<GroupStream> streams = Arrays.asList(groupStream, groupStream);

        // Создаем сервис для работы с потоками
        StreamService service = new StreamService();

        // Создаем контроллер и вызываем метод сортировки
        Controller controller = new Controller(service);
        controller.sortStreams(streams);

        // Выводим результат
        for (GroupStream stream : streams) {
            System.out.println(stream);
        }
    }
}
