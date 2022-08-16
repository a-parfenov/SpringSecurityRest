const addForm = document.getElementById("addForm");
addForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData(addForm);
    const object = {
        roles:[]
    };

    formData.forEach((value, key) => {
        if (key === "rolesId"){

            const roleId = value.split(" ")[0];
            const roleName = value.split(" ")[1];
            const role = {
                id : roleId,
                role : roleName
            };
            object.roles.push(role);
        } else {
            object[key] = value;
        }
    });

    fetch("api/admin/", {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(() => getUsers())
        .then(() => addForm.reset());

    return show('users','newUser');
})
