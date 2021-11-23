
package com.codeclan.example.files_and_folders.components;

import com.codeclan.example.files_and_folders.models.File;
import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.models.User;
import com.codeclan.example.files_and_folders.repositories.FileRepository;
import com.codeclan.example.files_and_folders.repositories.FolderRepository;
import com.codeclan.example.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        User user1 = new User("user1");
        userRepository.save(user1);

        Folder folder1 = new Folder("folder1", user1);
        folderRepository.save(folder1);

        File file1 = new File("file1", ".mp3", 1, folder1);
        fileRepository.save(file1);

        user1.addFolder(folder1);
        userRepository.save(user1);

        folder1.addFile(file1);
        folderRepository.save(folder1);
    }
}
