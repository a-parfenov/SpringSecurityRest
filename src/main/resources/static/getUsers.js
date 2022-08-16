async function getUsers() {

    const response = await fetch("api/admin/");

    if (response.ok) {
        let json = await response.json()
            .then(data => replaceTable(data));
    } else {
        alert("Ошибка HTTP: " + response.status);
    }

    function replaceTable(data) {

        const placement = document.getElementById("usersTablePlacement")
        placement.innerHTML = "";
        data.forEach(({id, name, surname, username, email, roles}) => {
            let userRoles = "";
            roles.forEach((role) => {
                userRoles = userRoles + role.role.replace("ROLE_", "") + " ";
            })
            const element = document.createElement("tr");

            element.innerHTML = `
            <th scope="row">${id}</th>
            <td>${name}</td>
            <td>${surname}</td>
            <td>${username}</td>
            <td>${email}</td>
            <td>${userRoles}</td>
            <td>
                <button type="button" class="btn btn-info text-white" 
                    data-bs-userId=${id}
                    data-bs-userName=${name} 
                    data-bs-userSurname=${surname} 
                    data-bs-userUsername=${username} 
                    data-bs-userEmail=${email} 
                    data-bs-toggle="modal"
                    data-bs-target="#ModalEdit">Edit</button>
            </td>
            <td>
                <button type="button" class="btn btn-danger" 
                    data-bs-userId=${id}
                    data-bs-userName=${name} 
                    data-bs-userSurname=${surname} 
                    data-bs-userUsername=${username} 
                    data-bs-userEmail=${email} 
                    data-bs-toggle="modal"
                    data-bs-target="#ModalDelete">Delete</button>
            </td>            
            `
            placement.append(element);
        })
    }
}
