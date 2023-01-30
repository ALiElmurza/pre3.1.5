$(async function () {
    await newUser();
});

async function newUser() {
    await fetch("http://localhost:8088/api/roles")
        .then(r => r.json())
        .then(roles => {
            roles.forEach(role => {
                let element = document.createElement("option");
                element.text = role.name.substring(5);
                element.value = role.id;
                $('#rolesNewUser')[0].appendChild(element);
            })
        })

    const formAddNewUser = document.forms["formAddNewUser"];

    formAddNewUser.addEventListener('submit', function (event) {
        event.preventDefault();
        let rolesNewUser = [];
        for (let i = 0; i < formAddNewUser.roles.options.length; i++) {
            if (formAddNewUser.roles.options[i].selected) rolesNewUser.push({
                id: formAddNewUser.roles.options[i].value,
                name: formAddNewUser.roles.options[i].name
            })
        }

        fetch("http://localhost:8088/api/admin", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: formAddNewUser.firstName.value,
                lastName: formAddNewUser.lastName.value,
                age: formAddNewUser.age.value,
                email: formAddNewUser.email.value,
                password: formAddNewUser.password.value,
                roles: rolesNewUser
            })
        }).then(() => {
            formAddNewUser.reset();
            users();
            $('#allUsersTable').click();
        })
            .catch((error) => {
                alert(error);
            })
    })

}
